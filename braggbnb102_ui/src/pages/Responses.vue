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
            <response-table
            v-if="responses && responses.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:responses="responses"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-responses="getAllResponses"
             >

            </response-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import ResponseTable from "@/components/ResponseTable";
import ResponseService from "../services/ResponseService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    ResponseTable,
  },
  data() {
    return {
      responses: [],
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
    async getAllResponses(sortBy='responseId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await ResponseService.getAllResponses(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.responses.length) {
					this.responses = response.data.responses;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching responses:", error);
        }
        
      } catch (error) {
        console.error("Error fetching response details:", error);
      }
    },
  },
  mounted() {
    this.getAllResponses();
  },
  created() {
    this.$root.$on('searchQueryForResponsesChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllResponses();
    })
  }
};
</script>
<style></style>
