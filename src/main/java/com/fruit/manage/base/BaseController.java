package com.fruit.manage.base;

import com.fruit.manage.util.DataResult;
import com.jfinal.core.Controller;

public abstract class BaseController extends Controller{
	/**
	 * 返回操作状态，如果错误就全局处理，如果成功则不返回结果
	 * @param result
	 */
	public void renderResult(DataResult<Object> result){
		renderResult(result.isSuccessCode(), result.getMsg());
	}
	public void renderResult(boolean result){
		renderResult(result, "操作异常，稍后请重试");
	}
	public void renderResult(boolean result, String errorMsg){
		if (result){
			renderNull();
		}else{
			renderErrorText(errorMsg);
		}
	}
	
	/**
	 * 返回错误码及对应的错误提示，可全局处理
	 * Render with view and errorCode status
	 */
	public void renderErrorText(String errorText) {
		int errorCode = 420;
		render(new ErrorTextRender(errorCode, errorText));
//		throw new ActionException(errorCode, new ErrorTextRender(errorCode, errorText));
	}
}
