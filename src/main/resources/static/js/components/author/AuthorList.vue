<template>
  <div class="container">
    <h2>Authors list</h2>
    <AuthorForm :authors="authors" :authorAttr="author"/>

    <div class>
      <table class="table table-striped col-12">
        <thead>
          <tr>
            <th scope="col" style="width: 5%">#</th>
            <th scope="col" style="width: 40%">Name</th>
            <th scope="col" style="width: 40%">Surname</th>
            <th scope="col" style="width: 15%">Operation</th>
          </tr>
        </thead>
        <tbody>
          <AuthorRow
            v-for="author in authors"
            :key="author.id"
            :author="author"
            :editAuthor="editAuthor"
            :deleteAuthor="deleteAuthor"
          />
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import AuthorForm from "components/author/AuthorForm.vue";
import AuthorRow from "components/author/AuthorRow.vue";
import axios from "axios";

export default {
  props: [],
  components: {
    AuthorForm,
    AuthorRow
  },
  data() {
    return {
      author: null,
      authors: []
    };
  },
  methods: {
    editAuthor(author) {
      this.author = author;
    },
    deleteAuthor(author) {
      this.$resource("/author{/id}")
        .remove({ id: author.id })
        .then(result => {
          if (result.ok) {
            this.authors.splice(this.authors.indexOf(author), 1);
          }
        });
    }
  },

  created: function() {
    axios.get("/author").then(response => {
      this.authors = response.data
    }).catch(error => console.log(error))
  }
};
</script>

