
function count(val){
    console.log( "counter clicked");
}

export default function Counter() {
return (
    <div className="counter" >
            <div><span className="count">0</span></div>
            <button className="count-btn Increment" onClick={count}>Increment</button>
            <button className="count-btn reset" >Reset</button>
            <button className="count-btn Decrement" onClick={count}>Decrement</button>
        </div>
    )
}