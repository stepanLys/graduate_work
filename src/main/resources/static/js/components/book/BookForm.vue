<template>
  <form>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="Title" v-model="title">
    </div>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="Description" v-model="description">
    </div>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="Price" v-model="price">
    </div>
    <div class="form-group">
      <div >
        <label v-bind:key="genre.id" v-for="genre in allGenres">
          <input type="checkbox" v-bind:value="genre" v-model="genres">
          {{ genre.name }}
        </label>
      </div>
    </div>

    <div class="form-group">
      <select v-model="author">
        <option
          v-bind:key="a.id"
          v-bind:value="a"
          v-for="a in allAuthors"
        >{{ a.name }} {{ a.surname }}</option>
      </select>
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
  props: ["books", "bookAttr", "authors"],
  data() {
    return {
      id: "",
      title: "",
      description: "",
      price: "",
      genres: [],
      author: {},
      allAuthors: [],
      allGenres: []
    };
  },
  watch: {
    bookAttr(newVal, oldVal) {
      this.id = newVal.id;
      this.title = newVal.title;
      this.description = newVal.description;
      this.price = newVal.price;
      this.genres = newVal.genres;
      this.author = newVal.author;
    }
  },
  methods: {
    save() {
      const book = {
        title: this.title,
        description: this.description,
        price: this.price,
        genres: this.genres,
        author: this.author
      };
      if (this.id) {
        axios
          .put("/book/" + this.id, book)
          .then(result => {
            let data = result.data;

            const index = getIndex(this.books, data.id);
            this.books.splice(index, 1, data);
            this.title = "";
            this.description = "";
            this.price = "";
            this.genres = [];
            this.author = {};
          })
          .catch(error => {
            console.log(error);
          });
      } else {
        axios
          .post("/book", book)
          .then(result => {
            let data = result.data;
            this.books.push(data);

            this.title = "";
            this.description = "";
            this.price = "";
            this.genres = [];
            this.author = {};
          })
          .catch(error => {
            console.log(error);
          });
      }
    }
  },
  mounted: function() {
    axios
      .get("/author")
      .then(response => {
        this.allAuthors = response.data;
      })
      .catch(error => console.log(error));
    axios
      .get("/genre")
      .then(response => {
        this.allGenres = response.data;
      })
      .catch(error => console.log(error));
  }
};
</script>
