<template>
  <tr>
    <th scope="row">{{ book.id }}</th>
    <td>{{ book.title }}</td>
    <td>{{ book.description }}</td>
    <td>{{ book.price }}</td>
    <td> <span v-bind:key="g.id" v-for="g in book.genres">{{ g.name }} <br> </span> </td>
    <td>{{ book.author.name }} <br/> {{ book.author.surname }}</td>
    <td>
      <button class="btn btn-primary" @click="edit">Edit</button>
      <button class="btn btn-danger" @click="del">Delete</button>
    </td>
  </tr>
</template>

<script>
import axios from "axios";

export default {
  props: ["book", "books", "editBook", "deleteBook"],
  methods: {
    edit() {
      this.editBook(this.book);
    },
    del() {
      this.deleteBook(this.book);
    }
  }
};
</script>

