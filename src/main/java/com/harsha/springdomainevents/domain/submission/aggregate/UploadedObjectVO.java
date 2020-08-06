package com.harsha.springdomainevents.domain.submission.aggregate;

class UploadedObjectVO {
    private String publicUrl;
    private Boolean isDownloadable;

    public UploadedObjectVO(String publicUrl, Boolean isDownloadable) {
        this.publicUrl = publicUrl;
        this.isDownloadable = isDownloadable;
    }
}
