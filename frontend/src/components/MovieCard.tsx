import axios from "axios";
import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {Movie} from "../models/movie.tsx";

export default function MovieCard() {
    const navigate = useNavigate()
    const {id} = useParams();
    const [movie, setMovie] = useState({} as Movie);

    async function fetchMovie() {
        try {
            const response = await axios.get(`/api/movies/${id}`);
            setMovie(response.data);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    }

    async function deleteFunction(id: string) {
        try {
            const response = await axios.delete(`/api/movies/${id}`)
            console.log("Movie deleted successfully:", response.statusText)
            navigate("/movies")

        } catch (error) {
            console.log("There was an error deleting the movie:", error)

        }
    }

    useEffect(() => {
        fetchMovie();
    }, [id]);

    function handleDelete() {
        deleteFunction(movie.id);
    }


    return (
        <div>
            <h2>Movie Title: {movie.title}</h2>
            <p>Author: {movie.author}</p>
            {/* <p>Genre: {movie.genre}</p>
            <p>Date of publication: {movie.date}</p>*/}
            <button onClick={handleDelete}>X</button>
        </div>
    )
}