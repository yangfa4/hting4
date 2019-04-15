package com.sy.demo.action.lhq;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/lhq/api")
public class orderAdvertisementApplyAction {
    
	@GetMapping("orderAdvertise2")
	public String orderAdvertise() {
		System.out.println("进入修改2");
		return  "lhq/NewFile";
	}
	
	@ResponseBody
	@PostMapping(value = "/saveImage")
	public String saveImage(String image,String fileName){
		System.out.println("图片路径："+image+"图片名称："+fileName);
		//BaseResponse<MyFavorite> result = new BaseResponse<MyFavorite>();
		try {
		//输出base64 数据,截取","之后的值进行转换
        String str = image.substring(image.indexOf(",")+1);
        //System.currentTimeMillis()意思是获取当前系统的时间戳给图片命名
        //实例化Base64转换类  调用里面的GenerateImage方法（把base64数据转为图片）
        //第一个参数base64转图片的必须的base64数据，第二个是转换后生成的图片存放路径
        String imagePath = "E:/images/"+System.currentTimeMillis()+".png";
        GenerateImage(str, imagePath);
        //数据库存入绝对路径下的图片路径及名称（上传图片即是修改操作）
      /*  String loginUser = SessionHelper.GetLoginUserCode();
		User user = userRepository.getByName(loginUser);
		user.setImagePath(imagePath);
		//更新用户头像地址
		userRepository.updateImagePath(user);
		result.code = 200;*/
		} catch (Exception e) {
			e.printStackTrace();
			/*result.code = 500;
			result.setMsg("服务器错误");*/
		}
		return null;
	}
	
	//base64字符串转化成图片  
    public static boolean GenerateImage(String imgStr,String imageName){
        //对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) //图像数据为空  
            return false;  
        try{     
            //Base64解码  
        	byte[] b = Base64.decodeBase64(imgStr.replace("data:image/png;base64,",""));
        	imgStr = imgStr.replace("base64,","");
            for(int i=0;i<b.length;++i) {  
                if(b[i]<0){  
                //调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成jpeg图片  
            String imgFilePath = imageName;//新生成的图片  
            OutputStream out = new FileOutputStream(imgFilePath);      
            out.write(b);  
            out.flush();  
            out.close();  
            return true;  
        } catch (Exception e) {   
            return false;  
        }  
    } 
    
  //  @GetMapping(value = "/showImg")
   // @ResponseBody
//    public void showImg( HttpServletRequest request,HttpServletResponse response) {
//     String loginUser = SessionHelper.GetLoginUserCode();
//	 User user = userRepository.getByName(loginUser);
//	 //查询当前登录用户图片地址
//	 String pathName = userRepository.getImagePath(user.getUserCode());
//     File imgFile = new File(pathName);
//     FileInputStream fin = null;
//     OutputStream output=null;
//     try {
//      output = response.getOutputStream();
//      fin = new FileInputStream(imgFile);
//      byte[] arr = new byte[1024*10];
//      int n;
//      while((n=fin.read(arr))!= -1){
//       output.write(arr, 0, n);
//      }
//      output.flush();
//      output.close();
//     } catch (IOException e) {
//      e.printStackTrace();
//     }

    


}
