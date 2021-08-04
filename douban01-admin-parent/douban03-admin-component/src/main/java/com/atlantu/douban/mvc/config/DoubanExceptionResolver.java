package com.atlantu.douban.mvc.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler;

import com.atlantu.douban.util.DoubanUtil;
import com.atlantu.douban.util.ResultEntity;
import com.google.gson.Gson;

//@ControllerAdvice��ʾ��ǰ����һ������ע����쳣��������
@ControllerAdvice
public class DoubanExceptionResolver {

	@ExceptionHandler(value = ArithmeticException.class)
	public ModelAndView resolveMathException(
			ArithmeticException exception,
			HttpServletRequest request,
			HttpServletResponse response
			) throws IOException {

		String viewName = "system-error";

		return commonResolve(viewName, exception, request, response);
	}

	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView resolveNullPointerException(

			// ʵ�ʲ��񵽵��쳣����
			NullPointerException exception,

			//��ǰ�������
			HttpServletRequest request,

			//��ǰ��Ӧ����
			HttpServletResponse response) throws IOException {

		String viewName = "system-error";

		return commonResolve(viewName, exception, request, response);
	}

	//@ExceptionHandler��һ��������쳣���ͺ�һ��������������
	public ModelAndView commonResolve(

			// �쳣������ɺ�Ҫȥ��ҳ��
			String viewName, 

			// ʵ�ʲ��񵽵��쳣����
			Exception exception,

			//��ǰ�������
			HttpServletRequest request,

			//��ǰ��Ӧ����
			HttpServletResponse response) throws IOException {

		// 1.�жϵ�ǰ��������
		boolean judgeResult=DoubanUtil.judgeRequestType(request);

		// 2.�����Ajax����
		if(judgeResult) {

			// 3.����ResultEntity����
			ResultEntity<Object> resultEntity=ResultEntity.failed(exception.getMessage());

			// 4.����Gson����
			Gson gson=new Gson();

			// 5.��ResultEntity����ת��ΪJSON�ַ���
			String json=gson.toJson(resultEntity);

			// 6.��JSON�ַ�����Ϊ��Ӧ�巵�ظ������
			response.getWriter().write(json);

			// 7.���������Ѿ�ͨ��ԭ����response���󷵻�����Ӧ�����Բ��ṩModelAndView����
			return null;
		}

		// 8.�������Ajax�����򴴽�ModelAndView����
		ModelAndView modelAndView=new ModelAndView();

		// 9.��Exception�������ģ��
		modelAndView.addObject("exception",exception);

		// 10.���ö�Ӧ����ͼ����
		modelAndView.setViewName(viewName);

		// 11.����modelAndView����
		return modelAndView;
	}

}