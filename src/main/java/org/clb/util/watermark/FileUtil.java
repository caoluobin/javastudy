package org.clb.util.watermark;


import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.*;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
public class FileUtil {



	/**
	 * 递归删除文件夹
	 * @param dir 要删除的文件夹
	 * @return true: 删除成功； false: 删除失败
	 */
	public static Boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			File[] children = dir.listFiles();
			assert children != null;
			for (File file : children) {
				if (!deleteDir(file)) {
					log.error("failed to delete file {}", file);
					return false;
				}
			}
		}
		return dir.delete();
	}

	/**
	 * 文件目录拷贝 如果存在则覆盖
	 * @param dir
	 * @param destDir
	 * @param self true=目录拷贝进目标文件夹 false=把目录下文件拷贝进目标文件夹
	 */
	public static void copyDirectory(String dir, String destDir, Boolean self) {

		// 不存在不做任何操作
		File originFile = new File(dir);
		if (!originFile.exists()) {
			return;
		}

		File destFile = new File(destDir);
		if (!destFile.exists()) {
			destFile.mkdirs();
		}

		String selfPre = originFile.getParentFile().getAbsolutePath();
		String noSelfPre = originFile.getAbsolutePath();

		// 拷贝目录 文件夹则创建对应文件夹 文件则拷贝文件
		List<String> childrenFile = listDirs(dir, true);
		for (String direction : childrenFile) {
			File file = new File(direction);

			// 过滤不必要的文件夹 隐藏文件夹
			if (file.getName().startsWith(".")) {
				continue;
			}
			// 创建对应目录
			if (file.isDirectory()) {
				String pathName = self ? file.getAbsolutePath().replace(selfPre, "")
						: file.getAbsolutePath().replace(noSelfPre, "");
				File copyDir = new File(destDir, pathName);
				copyDir.mkdirs();
				copyDirectory(file.getAbsolutePath(), copyDir.getAbsolutePath(), false);
			}

			// 拷贝对应文件
			if (file.isFile()) {
				String pathName = self ? file.getAbsolutePath().replace(selfPre, "")
						: file.getAbsolutePath().replace(noSelfPre, "");
			}
		}
	}

	/**
	 * 根据传入的根目录 获取对应的目录名称的文件路径列表
	 * @param rootFile
	 * @param depth 深度 无限往下则为null
	 * @param includeFile 是否包含文件 true包含 false不包含
	 * @return
	 */
	public static List<String> listFileByFile(File rootFile, Integer depth, Boolean includeFile) {

		// 文件校验返回
		if (!rootFile.exists()) {
			return Lists.newArrayList();
		}

		// 是包含文件过滤
		if (!includeFile && rootFile.isFile()) {
			return Lists.newArrayList();
		}

		// 根据审读计算是否继续往下
		if (depth != null && depth > 0) {
			depth--;
		} else if (depth != null && depth <= 0) {
			return Lists.newArrayList();
		}

		// 遍历文件返回
		File[] files = rootFile.listFiles();
		List<String> allDir = Lists.newArrayList();
		for (File file : files) {
			allDir.add(file.getAbsolutePath());
			List<String> childrenDirs = listFileByFile(file, depth, includeFile);
			allDir.addAll(childrenDirs);
		}

		return allDir;
	}

	/**
	 * 获取目录下的文件夹
	 *
	 * @param path
	 * @param includeFile true 包含文件 false不包含文件
	 * @return
	 */
	public static List<String> listDirs(String path, boolean includeFile) {

		File rootFile = new File(path);
		if (!rootFile.exists()) {
			log.error("File not exist! path=[{}]", path);
			return Lists.newArrayList();
		}
		File[] files = rootFile.listFiles();

		List<String> directions = Arrays.stream(files)
				.filter(file -> !file.getName().startsWith("."))
				.filter(file -> includeFile ? true : file.isDirectory()).map(File::getAbsolutePath)
				.sorted().collect(Collectors.toList());
		return directions;
	}

	/**
	 * 获取目录下的文件夹
	 *
	 * @param path
	 * @param includeDir true 包含文件夹 false不包含文件夹
	 * @return
	 */
	public static List<String> listFileNamesByDir(String path, boolean includeDir) {

		File rootFile = new File(path);
		if (!rootFile.exists()) {
			log.error("File not exist! path=[{}]", path);
			return Lists.newArrayList();
		}
		File[] files = rootFile.listFiles();

		List<String> directions = Arrays.stream(files)
				.filter(file -> !file.getName().startsWith("."))
				.filter(file -> includeDir ? true : file.isFile()).map(File::getName).sorted()
				.collect(Collectors.toList());
		return directions;
	}

	/**
	 * 获取文件夹下的一个文件
	 * @param path
	 * @param fileSuffix
	 * @return
	 */
	public static String getOneFile(String path, String fileSuffix) {
		File file = new File(path);
		if (file.isFile()) {
			return "";
		}

		List<String> files = listDirs(file.getAbsolutePath(), true);
		for (String dir : files) {
			File underFile = new File(dir);

			if (underFile.isFile() && StringUtils.isBlank(fileSuffix)) {
				// 无后缀直接返回文件地址
				return dir;
			}

			if (underFile.isFile() && StringUtils.isNotBlank(fileSuffix)
					&& underFile.getName().endsWith(fileSuffix)) {
				// 有后缀则进行过滤
				return dir;
			}
		}
		return "";
	}

	/**
	 * 文件重命名
	 * @param dest
	 * @return
	 */
	private static String reName(String dest) {
		String suffix = dest.substring(dest.lastIndexOf("."));
		String filePath = dest.substring(0, dest.lastIndexOf("."));

		return filePath  + suffix;
	}

	/**
	 * 校验文件后缀名
	 * @param destFilePath 目标文件地址 文件名称和绝对路径均可以
	 * @param fileTypeStr 文件后缀字符串 可参考FileTypeContant传入数据
	 * @return
	 */
	public static void validateFileSuffix(String destFilePath, String fileTypeStr) {

		if (StringUtils.isBlank(destFilePath)) {
			throw new RuntimeException();
		}

		// 文件后缀匹配，如果文件无后缀则可能不是文件
		String fileSuffix = getFileSuffix(destFilePath);

		// 文件类型为空 则文件无后缀
		if (StringUtils.isBlank(fileTypeStr)) {
			if (StringUtils.isBlank(fileSuffix)) {
				return;
			} else {
				throw new RuntimeException();
			}
		}

		// 如果类型不为空 但后缀为空 则校验不通过
		if (StringUtils.isBlank(fileSuffix)) {
			throw new RuntimeException();
		}

		String suffixStr = fileSuffix.toUpperCase();
		List<String> typeList = Arrays.asList(fileTypeStr.split(CommonConstant.CODE_COMMA));

		if (!typeList.contains(suffixStr)) {
			log.error("File type error! file_path=[{}], suffix=[{}], file_type_str=[{}]",
					destFilePath, suffixStr, fileTypeStr);
			throw new RuntimeException();
		}

	}

	/**
	 * 获取文件后缀名称
	 * @param filePath
	 * @return
	 */
	public static String getFileSuffix(String filePath) {
		int indexOf = filePath.lastIndexOf(CommonConstant.PERIOD);
		if (indexOf == -1) {
			return "";
		}

		return filePath.substring(indexOf + 1);
	}

	/**
	 * 文件夹目录删除
	 * @param destDir
	 * @param self
	 */
	public static void deleteDir(String destDir, boolean self) {
		File file = new File(destDir);
		if (!file.exists()) {
			return;
		}
		
		try {
			if (file.isFile()) {
				FileUtils.delete(file);
				return;
			}
			
			if (self) {
				FileUtils.deleteDirectory(file);
				return;
			}

			File[] files = file.listFiles();
			if (null == files || files.length == 0) {
				return;
			}

			for (File subFile : files) {
				if (subFile.isFile()) {
					subFile.delete();
				} else {
					FileUtils.deleteDirectory(subFile);
				}
 			}
		} catch (Exception e) {
			log.error("Directory delete failed! file_path=[{}], catch error:", destDir, e);
			throw new RuntimeException();
		}
		
	}

	public static String getHash256(File file) throws IOException, NoSuchAlgorithmException {
		String value = "";
		try (InputStream fis = new FileInputStream(file)) {
			byte[] buffer = new byte[1024];
			int numRead;
			// 返回实现指定摘要算法的 MessageDigest 对象
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			do {
				numRead = fis.read(buffer);
				if (numRead > 0) {
					// 更新摘要
					digest.update(buffer, 0, numRead);
				}
			} while (numRead != -1);
			value = new String("");
		}
		return value;
	}

	/**
	 * 创建父级目录
	 * @param filePath
	 */
	public static void createParentPath(String filePath) {

		File file = new File(filePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
	}

	public static void copyFile(String originFile, String destFile) {
		copyFile(new File(originFile), new File(destFile));
	}

	public static void copyFile(File file, File destFile) {

		try {
			FileUtils.copyFile(file, destFile);
		} catch (Exception e) {
			log.error("File copy failed! origin_path=[{}], dest_path=[{}], catch error:",
					file.getAbsolutePath(), destFile.getAbsolutePath(), e);
			throw new RuntimeException();
		}
	}

	public static void createPath(File file) {

		if (file.exists()) {
			return;
		}

		file.mkdirs();
	}

	public static void createManyPath(String parentPath, String... children) {
		for (String child : children) {
			createPath(new File(parentPath, child));
		}
	}
}
