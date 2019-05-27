<template>
  <tr>
    <th scope="row">{{ author.id }}</th>
    <td>{{ author.name }}</td>
    <td>{{ author.surname }}</td>
    <td>
      <button class="btn btn-primary" @click="edit">Edit</button>
      <button class="btn btn-danger" @click="del">Delete</button>
    </td>
  </tr>
</template>

<script>
export default {
  props: ["author", "editAuthor", "deleteAuthor"],
  methods: {
    edit() {
      this.editAuthor(this.author);
    },
    del() {
      this.deleteAuthor(this.author);
    }
  }
};
</script>

