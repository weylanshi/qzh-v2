package com.qzh.store.feign;

import com.huidong.qzh.util.common.util.QzhResult;
import com.qzh.store.config.FeignMultipartSupportConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "qzh-file", configuration = FeignMultipartSupportConfig.class)
public interface FILEFeignClient {
    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public QzhResult handFileUpload(@RequestPart(value = "file") MultipartFile file, @RequestParam(value = "path") String path);


}
