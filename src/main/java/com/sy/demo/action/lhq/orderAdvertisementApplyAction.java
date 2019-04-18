package com.sy.demo.action.lhq;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sy.demo.biz.lhq.AdvertisementBiz;
import com.sy.demo.pojo.Advertisementapply;
import com.sy.demo.pojo.Bond;
import com.sy.demo.pojo.Languagetype;
import com.sy.demo.pojo.Majortype;
import com.sy.demo.pojo.User;


@Controller
@RequestMapping("/lhq/mvc")
public class orderAdvertisementApplyAction {
	@Autowired
	private AdvertisementBiz advertiseBiz;
	
	@GetMapping("orderAdvertise2")
	public String orderAdvertise() {
		System.out.println("进入修改2");
		return  "lhq/NewFile";
	}
	
	@PostMapping("addAdvertisementApply")
	public String shrz(Integer userID,Integer aid,String apcUrl,String aappUrl,float price,Integer rentAMonth,String startTime ,
			String endTime,
			MultipartFile Img1,HttpSession session) throws Exception {
		User use=(User) session.getAttribute("USER");
        System.out.println("输出userID:"+userID+",apcUrl:"+apcUrl+",price:"+price+",startTime:"+startTime);
		String path = null;// 文件路径	
		String fileName = Img1.getOriginalFilename();// 文件原名称
		 String type = null;// 文件类型
         System.out.println("上传的文件原名称:"+fileName);
		//Img1.transferTo(new File(File.separator + fileName));
		System.out.println("输出图片2"+File.separator + fileName);
		 type = fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
         if (type!=null) {// 判断文件类型是否为空
             if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                 // 项目在容器中实际发布运行的根路径
               String realPath = "F://image/";
                 // 自定义的文件名称
                 String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + type;
                 System.out.println("自定义的文件名称"+trueFileName);
                 // 设置存放图片文件的路径
                path = realPath+/*System.getProperty("file.separator")+*/trueFileName;
                 System.out.println("存放图片文件的路径:"+path);
                 // 转存文件到指定的路径
                 Img1.transferTo(new File(path));
                 String aimgPath="/"+trueFileName;
                SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
                 Date s=time.parse(startTime);
                 Advertisementapply apply=new Advertisementapply(apcUrl, userID, aappUrl, null,0, aimgPath, price, 1,time.parse(startTime), time.parse(endTime),rentAMonth,new Date(), aid);
                 
                 advertiseBiz.saveAdvertisementapply(apply);
                 }                 
             }else {
                 System.out.println("不是我们想要的文件类型,请按要求重新上传");
             }
		
		//advertiseBiz.saveAdvertisementapply();
		/*if (index != -1) {
			user.setFirstServiceID(Integer.parseInt(serviceID.substring(0, index)));
			user.setSecondServiceID(Integer.parseInt(serviceID.substring(index + 1)));
		} else {
			user.setFirstServiceID(Integer.parseInt(serviceID));
		}*/
		/*if (user.getExperienceStatus() == 0) {
			user.setGuaranteeMoney(500); // 500保证金
			user.setUserMoney(user.getUserMoney() - 500); // 扣钱500保证金
		}*/
		return "redirect:/lhq/api/homeUrl";
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
