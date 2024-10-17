package com.kh.etc.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	public static final String SERVICE_KEY = "8h1yVur%2F0C1jzB%2BQnTVFLYlJk9Gfckktb8MFl25lzXaujB8wU9qgmg5abLreCLJnE2J%2FOK4DW5bqq0p4FPIEqw%3D%3D";
	
	
	@ResponseBody
	@GetMapping(value="air", produces="application/json; charset=UTF-8")
	public String getAirInfo(String location) throws IOException {
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey=" + SERVICE_KEY;
		url += "&returnType=json";
		url += "&sidoName=" + URLEncoder.encode(location, "UTF-8"); //요청시 전달값에 한글이 있으면 인코딩 작업 후 전송하기
		
		//1. 요청하고자하는 url을 전달하면서 java.net.URL객체 생성
		URL requestURL = new URL(url);
		
		//2. 만들어진 URL객체를 가지고 HttpURLConnection객체 생성
		HttpURLConnection urlConnection = (HttpURLConnection)requestURL.openConnection();
		
		//3. 요청에 필요한 Header정보 설정하기
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	
		String result = "";
		String line;
		while((line = br.readLine()) != null) {
			result += line;
		}
		
		br.close();
		urlConnection.disconnect();
		
		return result;
	}
	
}
