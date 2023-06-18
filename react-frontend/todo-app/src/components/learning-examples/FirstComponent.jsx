import SecondComponent from './SecondComponent';
import ThirdComponent from './ThirdComponent';
import { FourthComponent, FifthComponent } from './FourthComponent';

import "../../../src/App.css";


export default function FirstComponent() {
    return (
        <>
            <div className="first-component">First component text</div>
            <div className="other-component">
                <SecondComponent />
                <ThirdComponent />
                <FourthComponent />
                <FifthComponent />
            </div>
        </>
    );
}

