<template>
    <div>
        <h1>Item List</h1>
        <ul>
            <li v-for="item in items" :key="item.id">
                {{ item.name }}
            </li>
        </ul>
        <input v-model="newItem" placeholder="New item">
        <button @click="addItem">Add</button>
     </div> 
</template>

<script>
import axios from "axios"
export default {
    data() {
        return {
            items: [],
            newItem: ''
        }
    },
    methods: {
        fetchItems() {
            axios.get("http://localhost:8080/api/items").then(response => {
                this.items = response.data
            })
        },
        addItem() {
            axios.post("http://localhost:8080/api/items", {
                name: this.newItem
            }).then(()=> {
                this.newItem = '';
                this.fetchItems();
                
            })                
            },
        
    },
    mounted(){
            this.fetchItems();
        }
};
</script>
