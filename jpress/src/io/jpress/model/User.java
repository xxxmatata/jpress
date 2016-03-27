/**
 * Copyright (c) 2015-2016, Michael Yang 杨福海 (fuhai999@gmail.com).
 *
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jpress.model;

import io.jpress.core.annotation.Table;
import io.jpress.model.base.BaseUser;

@Table(tableName="user",primaryKey="id")
public class User extends BaseUser<User> {

	private static final long serialVersionUID = 1L;
	public static final User DAO = new User();
	
	public static String ROLE_ADMINISTRATOR = "administrator";
	
	
	public static User findUserByContentId(Long contentId){
		return DAO.doFindFirst( "content_id = ?",contentId);
	}
	
	public static User findUserById(long userId){
		return DAO.findById(userId);
	}
	
	public static User findUserByEmail(String email){
		return DAO.doFindFirst("email = ?",email);
	}
	
	public static User findUserByUsername(String username){
		return DAO.doFindFirst("username = ?",username);
	}
	
	public boolean isAdministrator(){
		return  "administrator".equals(getRole());
	}

}