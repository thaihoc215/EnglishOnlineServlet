package com.hochnt.core.common.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UploadUtil {

    private final Logger log = Logger.getLogger(this.getClass());
    private final int maxMemorySize = 1024 * 1024 * 3; //3MBl
    private final int maxRequestSize = 1024 * 1024 * 50; //50 MB

    public Object[] writeOrUpdateFile(HttpServletRequest request, Set<String> titleValue, String path) throws FileUploadException {
        boolean check = true;
        String fileName = null;

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            System.out.println("have not enctype multipart/form-data ");
            check = false;
        }
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Set factory constraints
        factory.setSizeThreshold(maxMemorySize);
        // cap dung luong chua tam thoi (cho chua)
        factory.setRepository((new File(System.getProperty("java.io.tmpdir"))));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(maxRequestSize);

        try {
            // Parse the request
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iter = items.iterator();
            for (FileItem item : items) {
                if (!item.isFormField()) { //=> not upload file
                    fileName = item.getName(); // file fileName
                    if (StringUtils.isNotBlank(fileName)) {
                        File uploadedFile = new File("D:\\" + fileName);
                        try {
                            boolean isExist = uploadedFile.exists();
                            if (isExist) {
                                uploadedFile.delete();
                                item.write(uploadedFile);
                            } else {
                                item.write(uploadedFile);
                            }
                        } catch (Exception e) {
                            check = false;
                            e.printStackTrace();
                        }
                    }
                } else { //=> dang upload file
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
            throw e;
        }

        return null;
    }

    private void checkAndCreateFolder(String address, String path) {

    }
}
