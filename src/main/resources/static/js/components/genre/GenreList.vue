<template>
  <div class="container">
    <h2>Genres list</h2>
    <GenreForm :genres="genres" :genreAttr="genre"/>

    <!-- <button @click="outerr">Show</button> -->

    <div class="">
      <table class="table table-striped col-12">
        <thead>
          <tr>
            <th scope="col" style="width: 5%">#</th>
            <th scope="col" style="width: 80%">Name</th>
            <th scope="col" style="width: 15%">Operation</th>
          </tr>
        </thead>
        <tbody>
          <GenreRow
            v-for="genre in genres"
            :key="genre.id"
            :genre="genre"
            :genres="genres"
            :editGenre="editGenre"
            :deleteGenre="deleteGenre"
          />
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import GenreForm from "components/genre/GenreForm.vue";
import GenreRow from "components/genre/GenreRow.vue";
import axios from 'axios';

export default {
  
  props: [],
  components: {
    GenreForm,
    GenreRow
  },
  data() {
    return {
      genre: null,
      genres: []
    };
  },
  methods: {
    editGenre(genre) {
      this.genre = genre;
    },
    deleteGenre(genre) {
      this.$resource("/genre{/id}")
        .remove({ id: genre.id })
        .then(result => {
          if (result.ok) {
            this.genres.splice(this.genres.indexOf(genre), 1);
          }
        });
        // allGenres = this.genres;
    },
    getGenres() {
      return genres;
    }
  },

  created: function() {
    axios.get("/genre").then(response => {
      this.genres = response.data;
      // allGenres = this.genres;
    }).catch(error => console.log(error))
  }
};
</script>

