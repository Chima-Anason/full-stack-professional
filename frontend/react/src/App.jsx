import UserProfile from "./UserProfile.jsx";
import {useState, useEffect} from "react";

const users = [
    {
        name: "Jamilia",
        age: 28,
        gender: "FEMALE"
    },
    {
        name: "Ana",
        age: 23,
        gender: "FEMALE"
    },
    {
        name: "Mike",
        age: 30,
        gender: "MALE"
    }
]

const UserProfiles = ({users}) => (
    <div>
        {users.map((user,index)=>(
            <UserProfile
                key={index}
                name={user.name}
                age={user.age}
                gender={user.gender}
                imageNumber={index}
            />
        ))}
    </div>
)
function App() {

    const [counter, setCounter] = useState(0);
    const [isLoading, setIsLoading] = useState(false);

    useEffect(()=>{
        setIsLoading(true)
        setTimeout(()=>{
            setIsLoading(false)
        }, 4000)
        return () => {
            console.log("cleanup functions")
        }
    }, [])

    if(isLoading){
        return "loading..."
    }
    return (
        <div>
            <button
                onClick={()=> setCounter(prevCounter => prevCounter+1)}>
                Increment counter
            </button>
            <h1>{counter}</h1>
            <UserProfiles users={users}/>
        </div>
    )
}

export default App