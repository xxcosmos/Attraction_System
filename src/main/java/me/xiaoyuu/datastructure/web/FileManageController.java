package me.xiaoyuu.datastructure.web;

import me.xiaoyuu.datastructure.dto.UploadExecution;
import me.xiaoyuu.datastructure.service.FileService;
import me.xiaoyuu.datastructure.util.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileManageController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, HttpSession session) {
        Session.dataManageSessionRemove(session);
        List<UploadExecution>list = fileService.uploadFile(request);
        StringBuilder s = new StringBuilder();
        for (UploadExecution execution:list){
            s.append(execution.getFileName()).append(execution.getStateInfo()).append("<br/>");
        }
        session.setAttribute("result", s.toString());
        return "redirect:/file_manage.jsp";
    }

    @RequestMapping(value = "/vex/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> vexDownload() {
        return fileService.downloadVexFile();

    }

    @RequestMapping(value = "/edge/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> edgeDownload() {
        return fileService.downloadEdgeFile();

    }




}
