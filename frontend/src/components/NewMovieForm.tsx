import axios from "axios";
import {FormEvent} from "react";

export default function NewMovieForm() {

    async function handleSubmit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault()
        const fd = new FormData(event.target as HTMLFormElement);
        const data = Object.fromEntries(fd);

        try {
            const response = await axios.post("/api/movies", {
                author: data.author,
                title: data.title,
                genre: data.genre,
                publicationDate: data.publicationDate
            });
            console.log('Movie added successfully:', response.data);
        } catch (error) {
            console.error('There was an error adding the movie:', error);
        }
    }

    return (
        <form onSubmit={handleSubmit} method="post">
            <label htmlFor="title">Title: </label>
            <input type="text" name="title"/>
            <label htmlFor="author">Author: </label>
            <input type="text" name="author"/>
            <label htmlFor="genre">Genre: </label>
            <input type="text" name="genre"/>
            <label htmlFor="publicationDate">Publication date: </label>
            <input type="datetime-local" name="publicationDate"/>
            <button>Add</button>
        </form>
    )
}