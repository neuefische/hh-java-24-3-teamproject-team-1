import {useEffect,useState} from "react";
import axios from 'axios';

import {Movie} from "../models/movie.tsx";

export default function ViewAllMovies() {
        const [movies, setMovies] = useState<Movie[]>([]);

    const fetchData = () => {
        axios.get('/api/movies')
            .then(response => {
                setMovies(response.data);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    };

    useEffect(() => {
        fetchData();

    }, []);
    return (
        <>
            {movies.map((movie) => (
                <h2 key={movie.id}>{movie.title} by {movie.author}</h2>
            ))}
        </>
    )
}