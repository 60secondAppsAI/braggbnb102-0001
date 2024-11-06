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
            <contactSupport-table
            v-if="contactSupports && contactSupports.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:contactSupports="contactSupports"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-contact-supports="getAllContactSupports"
             >

            </contactSupport-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import ContactSupportTable from "@/components/ContactSupportTable";
import ContactSupportService from "../services/ContactSupportService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    ContactSupportTable,
  },
  data() {
    return {
      contactSupports: [],
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
    async getAllContactSupports(sortBy='contactSupportId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await ContactSupportService.getAllContactSupports(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.contactSupports.length) {
					this.contactSupports = response.data.contactSupports;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching contactSupports:", error);
        }
        
      } catch (error) {
        console.error("Error fetching contactSupport details:", error);
      }
    },
  },
  mounted() {
    this.getAllContactSupports();
  },
  created() {
    this.$root.$on('searchQueryForContactSupportsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllContactSupports();
    })
  }
};
</script>
<style></style>
