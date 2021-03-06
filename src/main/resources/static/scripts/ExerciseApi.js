// Actual Vue.js script
var app = new Vue({
    el: '#main',
    data() {
        return {
            exercises: null,
            currName: '',
            currReps: '',
        }
    },
    mounted(){
        this.getExercises();
    },
    methods: {
    	getExercises: function() {
    		axios
              .get("/api/exercise/list")
              .then(response => (this.exercises = response.data))
    	},
    	addExercise: function(event) {
    		if (this.currName != null && this.currName != '') {
    			// TODO temp hardcoded categories
	    		axios
	              .post("http://localhost:8888/api/exercise/add", {
	            	  "name": this.currName,
	            	  "reps": this.currReps,
	            	  "sets": 5,
	            	  "restInSecs": 30,
	            	  "type": "STRENGTH",
	            	  "category": "ARMS",
	            	  "subcategory": "BICEP_TALL",
	            	  "intensityMode": "REGULAR"
	              })
	              .then(response => {
	            	  this.exercises.push(response.data);
	            	  this.currName = '';
	            	  this.currReps = '';
	          	  })
    		}
    	},
    	deleteExercise: function(exercise) {
    		if (exercise != null && exercise.id != null && exercise.id != '') {
	    		axios.delete("http://localhost:8888/api/exercise/delete?id=" + exercise.id);
	          	this.getExercises();
    		}
    	},
    },
})