import http from "../http-common"; 

class ContactSupportService {
  getAllContactSupports(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/contactSupport/contactSupports`, searchDTO);
  }

  get(contactSupportId) {
    return this.getRequest(`/contactSupport/${contactSupportId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/contactSupport?field=${matchData}`, null);
  }

  addContactSupport(data) {
    return http.post("/contactSupport/addContactSupport", data);
  }

  update(data) {
  	return http.post("/contactSupport/updateContactSupport", data);
  }
  
  uploadImage(data,contactSupportId) {
  	return http.postForm("/contactSupport/uploadImage/"+contactSupportId, data);
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

export default new ContactSupportService();
