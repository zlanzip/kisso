/**
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.kisso.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.kisso.Token;

/**
 * <p>
 * SSO 单点登录服务
 * </p>
 * 
 * @author hubin
 * @Date 2015-12-03
 */
public interface KissoService {

	/**
	 * 获取登录 Token
	 * 
	 * <p> 登录 </p>
	 */
	Token getToken( HttpServletRequest request );

	/**
	 * 在线人数（总数）
	 */
	String getLoginCount( HttpServletRequest request );

	/**
	 * 设置登录 Cookie
	 * 
	 * <p> 登录 </p>
	 */
	void setSSOCookie( HttpServletRequest request, HttpServletResponse response, Token token );


	/**
	 * 清理登录状态
	 * 
	 * <p> 退出 </p>
	 */
	boolean clearLogin( HttpServletRequest request, HttpServletResponse response );

	/**
	 * 退出并跳至登录页
	 * 
	 * <p> 退出 </p>
	 */
	void clearRedirectLogin( HttpServletRequest request, HttpServletResponse response ) throws IOException;

	/**
	 * 生成跨域询问密文
	 * 
	 * <p> 跨域</p>
	 */
	String askCiphertext( HttpServletRequest request, HttpServletResponse response, String privateKey );


	/**
	 * 生成跨域回复密文
	 * 
	 * <p> 跨域</p>
	 */
	String replyCiphertext( HttpServletRequest request, String userId, String askTxt, String tokenPk, String ssoPrk );


	/**
	 * 验证跨域回复密文，成功! 
	 * <p>
	 * 返回绑定用户ID
	 * </p>
	 * 
	 * <p> 跨域</p>
	 */
	String ok( HttpServletRequest request, HttpServletResponse response, String replyTxt, String atPk, String ssoPrk );
}
