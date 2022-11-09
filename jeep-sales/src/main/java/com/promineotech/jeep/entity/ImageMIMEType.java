package com.promineotech.jeep.entity;

public enum ImageMIMEType {
  IMAGE_JPEG("image/jpeg");
  private String mimeType;

  private ImageMIMEType(String mimeType) {
   this.mimeType = mimeType;
  }

  /**
   * 
   * @return
   */
  public String getMimeType() {
    return mimeType;
  }
  
  public static ImageMIMEType fromString(String mimeType) {
    for (ImageMIMEType imt : ImageMIMEType.values()) {
      if(imt.getMimeType().equals(mimeType)) {
        return imt;
      }
    }
    
    return null;
  }




}
