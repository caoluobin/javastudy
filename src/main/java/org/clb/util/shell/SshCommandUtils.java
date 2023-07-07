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
	 * 初始化
	 *
	 * @param ip       远程Linux地址
	 * @param port     端口
	 * @param username 用户名
	 * @param password 密码
	 * @throws JSchException JSch异常
	 */
	public void login(String ip, Integer port, String username, String password) {

		try {
			JSch jsch = new JSch();
			jsch.getSession(username, ip, port);
			session = jsch.getSession(username, ip, port);
			session.setPassword(password);

			// 设置第一次登陆的时候提示，可选值:(ask | yes | no)
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(1200 * 1000);
		} catch (Exception e) {

		}
	}

	private void doExec(String command, CMD_TYPE cmdType) {

		try {
			// 打开执行shell指令的通道
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
	 * 执行一条命令
	 */
	public List<String> execCmd(String command) {

		// 打开执行shell指令的通道
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

			// 打印运行结果

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
	 * 执行一条命令 获取错误流中的内容
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
