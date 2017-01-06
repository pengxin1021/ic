package com.ic.base.constants;

/**
 * Created by perxin on 2017/1/6.
 */
public class CommonConstants {

    public static final String SUCCESS_JSON = "\"status\":\"success\"";

    public static final String FAILURE_JSON = "\"status\":\"failure\"";

    public static enum ErrorCode {

        ERROR_CODE_CUSTOM(0xFF0000, "自定义"),
        ERROR_CODE_IMAGE_COMPRESS(0xFF1000, "图片压缩出错");

        private Integer code;

        private String description;

        ErrorCode(Integer code, String description) {
            this.code = code;
            this.description = description;
        }

        public ErrorCode customDescription(String customDescription) {
            ERROR_CODE_CUSTOM.code = code;
            ERROR_CODE_CUSTOM.description = customDescription;
            if (customDescription != null) {
                this.description = customDescription;
            }
            return this;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
