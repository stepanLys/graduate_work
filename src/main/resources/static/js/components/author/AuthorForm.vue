<template>
  <form>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="First name" v-model="name">
    </div>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="Last name" v-model="surname">
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
  props: ["authors", "authorAttr"],
  data() {
    return {
      id: "",
      name: "",
      surname: ""
    };
  },
  watch: {
    authorAttr(newVal, oldVal) {
      this.id = newVal.id;
      this.name = newVal.name;
      this.surname = newVal.surname;
    }
  },
  methods: {
    save() {
      const author = {
        name: this.name,
        surname: this.surname
      };

      if (this.id) {
        axios
          .put("/author/" + this.id, author)
          .then(result => {
            let data = result.data;

            const index = getIndex(this.authors, data.id);
            this.authors.splice(index, 1, data);
            this.name = "";
            this.surname = "";
          })
          .catch(error => {
            console.log(error);
          });
      } else {
        axios
          .post("/author", author)
          .then(result => {
            let data = result.data;

            this.authors.push(data);
            this.name = "";
            this.surname = "";
          })
          .catch(error => {
            console.log(error);
          });
      }
    }
  }
};
</script>
