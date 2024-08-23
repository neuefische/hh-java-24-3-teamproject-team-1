import axios from "axios";
import {FormEvent} from "react";
import {useNavigate} from "react-router-dom";
import {Movie} from "../models/movie.tsx";

export default function NewMovieForm({defaultMovie}:{defaultMovie:Movie}) {
    const navigate = useNavigate()

    async function handleSubmit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault()
        const fd = new FormData(event.target as HTMLFormElement);
        const data = Object.fromEntries(fd);

        try {
            const response = await axios.put(`/api/movies/${defaultMovie.id}`, {
                author: data.author,
                title: data.title,
                genre: data.genre,
                publicationDate: data.publicationDate
            });
            console.log('Movie added successfully:', response.data);
        } catch (error) {
            console.error('There was an error adding the movie:', error);
        }
        navigate("/")
    }


    return (
        <form onSubmit={handleSubmit} method="put">
            <label htmlFor="title">Title: </label>
            <input type="text" name="title" defaultValue={defaultMovie.title}/>
            <label htmlFor="author">Author: </label>
            <input type="text" name="author" defaultValue={defaultMovie.author}/>
            <label htmlFor="genre">Genre: </label>
            <input type="text" name="genre" defaultValue={defaultMovie.genre}/>
            <label htmlFor="publicationDate">Publication date: </label>
            <input type="datetime-local" name="publicationDate" defaultValue={defaultMovie.publicationDate.toString()}/>
            <button>Edit</button>
        </form>
    )
}