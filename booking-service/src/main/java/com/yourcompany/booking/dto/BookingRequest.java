package com.yourcompany.booking.dto;

import lombok.Data;

@Data
public class BookingRequest {
    private Long userId;      // instead of username
    private Long providerId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProviderId() {
		return providerId;
	}
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
}
