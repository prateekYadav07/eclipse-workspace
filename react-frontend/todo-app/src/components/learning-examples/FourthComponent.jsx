import { Component } from "react";
import "../../../src/App.css";

export class FourthComponent extends Component {
    render() {
        return <div className="other-component">Fourth component text</div>;
    }
}

export function FifthComponent() {
    return <div className="other-component">Fifth component text</div>;
}