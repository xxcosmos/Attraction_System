package me.xiaoyuu.datastructure.service;

import me.xiaoyuu.datastructure.dto.UploadExecution;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FileService {
    ResponseEntity<byte[]> downloadVexFile();

    List<UploadExecution> uploadFile(HttpServletRequest request);

    ResponseEntity<byte[]> downloadEdgeFile();
}
