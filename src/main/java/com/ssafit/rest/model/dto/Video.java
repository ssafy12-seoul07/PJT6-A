package com.ssafit.rest.model.dto;

public class Video {	
	private String videoId;
	private String title;
	private String part;
	private String channelName;
	private String url;
	private String thumbnail;
	private int viewCount;
	private int status;
	
	public Video() {
		// TODO Auto-generated constructor stub
	}
	
	public Video(String videoId, String title, String part, String channelName, String url, String thumbnail,
			int viewCount, int status) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.part = part;
		this.channelName = channelName;
		this.url = url;
		this.thumbnail = thumbnail;
		this.viewCount = viewCount;
		this.status = status;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", part=" + part + ", channelName=" + channelName
				+ ", url=" + url + ", thumbnail=" + thumbnail + ", viewCount=" + viewCount + ", status=" + status + "]";
	}
	
	
}
