import { useState } from "react";
import { PropTypes } from 'prop-types';

export default function CounterButton({ by, parentCounter }) {

    const [countVal, setCount] = useState(0);

    function count(event, val) {
        parentCounter(val)
        if ((countVal + val) >= 0)
            setCount(countVal + val);
    }

    return (
        <div className="counter" >
            {/* <div><span className="count">{countVal}</span></div> */}
            <button
                className="btn btn-1 Increment"
                onClick={event => count(event, by)}
            >
                +{by}</button>
            <button className="btn btn-3 Decrement" onClick={event => count(event, -by)}>-{by}</button>
        </div>
    )
}

CounterButton.propTypes = {
    by: PropTypes.number,
}

CounterButton.defaultProps = {
    by: 1
}