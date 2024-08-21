import axios from "axios";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import EditMovieForm from "./EditMovieForm.tsx";

export default function MovieCard() {
    const {id} = useParams();
    const [movie, setMovie] = useState();
    async function fetchMovie() {
        try {
            const response = await axios.get(`/api/movies/${id}`);
            setMovie(response.data);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    }

    useEffect(() => {
        fetchMovie();
    }, [id]);

    if (!movie) return (<p>Is loading...!</p>);

    return (
            <div>
                <h2>Movie Title: {movie.title}</h2>
                <p>Author: {movie.author}</p>
                <p>Genre: {movie.genre}</p>
                <p>Date of publication: {movie.publicationDate.toString()}</p>

                <EditMovieForm defaultMovie={ movie }/>
            </div>
        )
}