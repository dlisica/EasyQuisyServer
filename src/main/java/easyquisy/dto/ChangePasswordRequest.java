package easyquisy.dto;

public class ChangePasswordRequest {

	private String playerId;

	private String oldPassword;

	private String newPassword;

	public ChangePasswordRequest(String playerId, String oldPassword, String newPassword) {
		super();
		this.playerId = playerId;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
