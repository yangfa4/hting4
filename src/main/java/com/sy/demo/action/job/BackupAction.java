package com.sy.demo.action.job;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backup")
public class BackupAction {

	@RequestMapping("export")
	public Map<String, Object> exportDB(HttpSession session, String disk) throws Exception {
		
	
		String basePath = disk + ":/oadb";
		File file = new File(basePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		Calendar today = Calendar.getInstance();
		String sqlFileName = "oadb_" + String.valueOf(today.get(Calendar.YEAR))
				+ String.valueOf(today.get(Calendar.MONTH) + 1) + String.valueOf(today.get(Calendar.DATE))
				+ String.valueOf(today.get(Calendar.HOUR)) + String.valueOf(today.get(Calendar.MINUTE))
				+ String.valueOf(today.get(Calendar.SECOND)) + ".sql";
		String cmdStr = "cmd /c mysqldump -h127.0.0.1 -uroot -pyesheng hding > " + basePath + "/" + sqlFileName;
		Process p = Runtime.getRuntime().exec(cmdStr);
		Map<String, Object> message = new HashMap<String, Object>();
		message.put("code", "200");
		return message;
	}

	@RequestMapping("list")
	public List<String> dbFileList(String disk) throws Exception {
		String basePath = disk + ":/oadb";
		File file = new File(basePath);
		List<String> data = new ArrayList<>();
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				data.add(f.getAbsolutePath());
			}
		}
		return data;
	}

	@RequestMapping("import")
	public Map<String, Object> importDB(String path) throws Exception {
		String cmdStr = "cmd /c mysql  -h127.0.0.1 -uroot -pyesheng hding < " + path;
		Process p = Runtime.getRuntime().exec(cmdStr);
		Map<String, Object> message = new HashMap<String, Object>();
		message.put("code", "200");
		return message;
	}
}
