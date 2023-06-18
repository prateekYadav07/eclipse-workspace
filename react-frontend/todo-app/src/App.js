import "./App.css";
import { Component } from "react";

function App() {
  return (
    <div className="App">
      Todo Application app component
      <FirstComponent />
    </div>
  );
}

function FirstComponent() {
  return (
    <>
      <div className="first-component">First component text</div>
      <div className="other-component">
        <SecondComponent />
        <ThirdComponent />
        <FourthComponent />
      </div>
    </>
  );
}

function SecondComponent() {
  return <div className="other-component">Second component text</div>;
}

class ThirdComponent extends Component {
  render() {
    return <div className="other-component">Third component text</div>;
  }
}

class FourthComponent extends Component {
  render() {
    return <div className="other-component">Fourth component text</div>;
  }
}

export default App;
