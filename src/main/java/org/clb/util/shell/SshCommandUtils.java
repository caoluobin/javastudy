package org.clb.util.shell;

import com.google.common.collect.Lists;
import com.jcraft.jsch.*;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class SshCommandUtils {

	private Session session;

	private ChannelExec channelExec;

	private Channel channel;

	public SshCommandUtils() {}

	public SshCommandUtils(String ip, int port, String userName, String password) {
		login(ip, port, userName, password);
	}

	/**
	 * 鍒濆鍖�
	 *
	 * @param ip       杩滅▼Linux鍦板潃
	 * @param port     绔彛
	 * @param username 鐢ㄦ埛鍚�
	 * @param password 瀵嗙爜
	 * @throws JSchException JSch寮傚父
	 */
	public void login(String ip, Integer port, String username, String password) {

		try {
			JSch jsch = new JSch();
			jsch.getSession(username, ip, port);
			session = jsch.getSession(username, ip, port);
			session.setPassword(password);

			// 璁剧疆绗竴娆＄櫥闄嗙殑鏃跺�欐彁绀猴紝鍙�夊��:(ask | yes | no)
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(1200 * 1000);
		} catch (Exception e) {

		}
	}

	private void doExec(String command, CMD_TYPE cmdType) {

		try {
			// 鎵撳紑鎵цshell鎸囦护鐨勯�氶亾
			channel = session.openChannel("exec");
			channelExec = (ChannelExec) channel;
			channelExec.setCommand(command);

			if (cmdType == CMD_TYPE.ERR) {
				channelExec.setInputStream(System.in);
				channelExec.setErrStream(null);
			} else {
				channelExec.setInputStream(null);
				channelExec.setErrStream(System.err);
			}

			channel.connect();
		} catch (JSchException e) {
			throw new RuntimeException();
		}

	}

	/**
	 * 鎵ц涓�鏉″懡浠�
	 */
	public List<String> execCmd(String command) {

		// 鎵撳紑鎵цshell鎸囦护鐨勯�氶亾
		doExec(command, CMD_TYPE.INFO);

		List<String> contentList = Lists.newArrayList();
		StringBuilder builder = new StringBuilder();
		try (InputStream in = channelExec.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr)) {

			String buffer;
			while ((buffer = br.readLine()) != null) {
				contentList.add(buffer);
				builder.append(buffer).append(System.lineSeparator());
			}

			// 鎵撳嵃杩愯缁撴灉

			return contentList;
		} catch (Exception e) {
			this.exit();
		} finally {
			closeChanel();
		}
		return null;
	}

	public String execCmdErrContent(String command) {
		return execCmdErrContent(command, true);
	}

	/**
	 * 鎵ц涓�鏉″懡浠� 鑾峰彇閿欒娴佷腑鐨勫唴瀹�
	 */
	public String execCmdErrContent(String command, boolean enableLog) {

		if (enableLog) {

		}

		doExec(command, CMD_TYPE.ERR);

		StringBuilder sb = new StringBuilder();
		try (InputStream in = channelExec.getErrStream();
				InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(isr)) {

			String buffer;
			while ((buffer = reader.readLine()) != null) {
				sb.append(buffer).append(System.lineSeparator());
			}

			if (StringUtils.isNotBlank(sb.toString())) {

			}

			return sb.toString();
		} catch (Exception e) {


			this.exit();
		} finally {
			closeChanel();
		}

		return null;
	}

	public void exit() {
		if (session != null && session.isConnected()) {
			session.disconnect();
		}
	}

	private void closeChanel() {
		if (channelExec != null && channelExec.isConnected()) {
			channelExec.disconnect();
		}
		if (channel != null && channel.isConnected()) {
			channel.disconnect();
		}
	}

	private enum CMD_TYPE {
		ERR, INFO
	}

}
