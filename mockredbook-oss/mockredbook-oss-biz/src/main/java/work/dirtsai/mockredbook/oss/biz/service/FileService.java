package work.dirtsai.mockredbook.oss.biz.service;

import org.springframework.web.multipart.MultipartFile;
import work.dirtsai.framework.common.response.Response;

public interface FileService {
    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    Response<?> uploadFile(MultipartFile file);
}
