package me.xiaoyuu.datastructure.serviceImpl;

import me.xiaoyuu.datastructure.dao.AttractionDao;
import me.xiaoyuu.datastructure.dao.RoadDao;
import me.xiaoyuu.datastructure.dto.UploadExecution;
import me.xiaoyuu.datastructure.entity.Attraction;
import me.xiaoyuu.datastructure.entity.Road;
import me.xiaoyuu.datastructure.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    AttractionDao attractionDao;
    @Autowired
    RoadDao roadDao;

    /**
     * (1) 读文件创建图
     * 输入：从Vex.txt文件中读取景点信息，从Edge.txt文件中读取道路信息。
     * 处理：根据读取的景区信息创建景区景点图。
     *
     * @param request
     * @return
     */
    @Override
    public List<UploadExecution> uploadFile(HttpServletRequest request) {
        //将request转换成文件request
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        //得到文件list
        List<MultipartFile> files = new ArrayList<>(multipartHttpServletRequest.getFileMap().values());

        List<UploadExecution> list = new ArrayList<>();
        roadDao.deleteAll();
        attractionDao.deleteAll();
        list.add(saveVexFileToDB(files.get(0)));
        list.add(saveEdgeFileToDB(files.get(1)));
        return list;
    }

    @Override
    public ResponseEntity<byte[]> downloadVexFile() {
        List<Attraction> attractions = attractionDao.getAll();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(attractions.size()).append("\n");
        for (Attraction attraction : attractions) {
            stringBuilder.append(attraction.getId()).append("\n");
            stringBuilder.append(attraction.getName()).append("\n");
            stringBuilder.append(attraction.getIntroduction()).append("\n");
        }
        return download("Vex.txt", stringBuilder.toString().getBytes());

    }

    @Override
    public ResponseEntity<byte[]> downloadEdgeFile() {
        List<Road> roads = roadDao.getAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (Road road : roads) {
            stringBuilder.append(road.getAttractionFirstId()).append('\t').append(road.getAttractionSecondId()).append('\t').append(road.getDistance()).append('\n');
        }
        return download("Edge.txt", stringBuilder.toString().getBytes());

    }

    private ResponseEntity<byte[]> download(String fileName, byte[] bytes) {
        HttpHeaders headers = new HttpHeaders();
        fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }

    private UploadExecution saveEdgeFileToDB(MultipartFile file) {
        if ("Edge.txt".equals(file.getOriginalFilename())) {
            try {
                InputStream in = file.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String s;
                while ((s = reader.readLine()) != null) {
                    int firstId = Integer.valueOf(s.split("\t")[0]);
                    int secondId = Integer.valueOf(s.split("\t")[1]);
                    int distance = Integer.valueOf(s.split("\t")[2]);
                    Road road = new Road(firstId, secondId, distance);
                    roadDao.insertRoad(road);
                }
                return new UploadExecution(file.getName(), 0, " is uploaded successfully");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return new UploadExecution(file.getName(), -1, "文件不存在");
            } catch (IOException e) {
                e.printStackTrace();
                return new UploadExecution(file.getName(), -1, "文件读入有误！");
            }
        } else {
            return new UploadExecution(file.getName(), -1, " is a wrong file!");
        }


    }


    private UploadExecution saveVexFileToDB(MultipartFile file) {
        if ("Vex.txt".equals(file.getOriginalFilename())) {
            try {
                InputStream in = file.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String s;
                int flag = -1;
                Attraction attraction = new Attraction();
                reader.readLine();
                while ((s = reader.readLine()) != null) {
                    flag++;
                    System.out.println(s);
                    if (flag == 0) {
                        attraction.setId(Integer.valueOf(s));
                    } else if (flag == 1) {
                        attraction.setName(s);
                    } else {
                        attraction.setIntroduction(s);
                        flag = -1;
                        attractionDao.addAttraction(attraction);
                        attraction = new Attraction();
                    }

                }
                return new UploadExecution(file.getName(), 0, " is uploaded successfully!");
            } catch (FileNotFoundException e) {
                return new UploadExecution(file.getName(), -1, "文件不存在!");
            } catch (IOException e) {
                return new UploadExecution(file.getName(), -1, "文件读取错误！");
            }
        } else {
            return new UploadExecution(file.getName(), -1, " is a wrong file!");
        }
    }

}