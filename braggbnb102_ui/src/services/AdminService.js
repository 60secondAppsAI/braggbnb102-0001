import http from "../http-common"; 

class AdminService {
  getAllAdmins(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/admin/admins`, searchDTO);
  }

  get(adminId) {
    return this.getRequest(`/admin/${adminId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/admin?field=${matchData}`, null);
  }

  addAdmin(data) {
    return http.post("/admin/addAdmin", data);
  }

  update(data) {
  	return http.post("/admin/updateAdmin", data);
  }
  
  uploadImage(data,adminId) {
  	return http.postForm("/admin/uploadImage/"+adminId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new AdminService();
