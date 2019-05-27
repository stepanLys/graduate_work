<template>
  <form>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="Genre" v-model="name">
    </div>
    <div class="form-group">
      <input type="button" class="btn btn-primary" value="Save" @click="save">
    </div>
  </form>
</template>

<script>
import axios from "axios";

function getIndex(list, id) {
  for (var i = 0; i < list.length; i++) {
    if (list[i].id === id) {
      return i;
    }
  }
  return -1;
}

export default {
  props: ["genres", "genreAttr"],
  data() {
    return {
      id: "",
      name: ""
    };
  },
  watch: {
    genreAttr(newVal, oldVal) {
      this.id = newVal.id;
      this.name = newVal.name;
    }
  },
  methods: {
    save() {
      const genre = {
        name: this.name
      };

      if (this.id) {
        axios
          .put("/genre/" + this.id, genre)
          .then(result => {
            let data = result.data;

            const index = getIndex(this.genres, data.id);
            this.genres.splice(index, 1, data);
            this.name = "";
          })
          .catch(error => {
            console.log(error);
          });
      } else {
        axios
          .post("/genre", genre)
          .then(result => {
            let data = result.data;

            this.genres.push(data);
            this.name = "";
          })
          .catch(error => {
            console.log(error);
          });
      }
    }
  }
};
</script>
