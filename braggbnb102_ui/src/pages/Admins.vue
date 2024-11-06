<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <admin-table
            v-if="admins && admins.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:admins="admins"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-admins="getAllAdmins"
             >

            </admin-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import AdminTable from "@/components/AdminTable";
import AdminService from "../services/AdminService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    AdminTable,
  },
  data() {
    return {
      admins: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllAdmins(sortBy='adminId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await AdminService.getAllAdmins(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.admins.length) {
					this.admins = response.data.admins;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching admins:", error);
        }
        
      } catch (error) {
        console.error("Error fetching admin details:", error);
      }
    },
  },
  mounted() {
    this.getAllAdmins();
  },
  created() {
    this.$root.$on('searchQueryForAdminsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllAdmins();
    })
  }
};
</script>
<style></style>
