<template>
  <tr>
    <th scope="row">{{ genre.id }}</th>
    <td>{{ genre.name }}</td>
    <td>
      <button class="btn btn-primary" @click="edit">Edit</button>
      <button class="btn btn-danger" @click="del">Delete</button>
    </td>
  </tr>
</template>

<script>
export default {
  props: ["genre", "genres", "editGenre", "deleteGenre"],
  methods: {
    edit() {
      this.editGenre(this.genre);
    },
    del() {
      this.deleteGenre(this.genre);
    }
  }
};
</script>

