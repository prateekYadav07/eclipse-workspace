import { useState } from "react";
import CounterButton from './counterButton'
import Reset from "./reset";

export default function Counter() {
    const [countVal, setCount] = useState(0);

    function parentCounter(val) {
        if ((countVal + val) >= 0)
            setCount(countVal + val);
    }

    function resetCounter() {
        setCount(0)
    }

    return (
        <>
            <CounterButton parentCounter={parentCounter} />
            <CounterButton parentCounter={parentCounter} by={2} />
            <CounterButton parentCounter={parentCounter} by={3} />
            <div className="count"><span >{countVal}</span></div>
            <Reset resetCounter={resetCounter} />
        </>
    )
}