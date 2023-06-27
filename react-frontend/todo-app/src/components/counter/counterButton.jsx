import { PropTypes } from 'prop-types';

export default function CounterButton({ by, parentCounter }) {

    return (
        <div className="counter" >
            {/* <div><span className="count">{countVal}</span></div> */}
            <button
                className="btn btn-1 Increment"
                onClick={() => parentCounter(by)}
            >
                +{by}</button>
            <button className="btn btn-3 Decrement" onClick={() => parentCounter(-by)}>-{by}</button>
        </div>
    )
}

CounterButton.propTypes = {
    by: PropTypes.number,
}

CounterButton.defaultProps = {
    by: 1
}