const person = {
    name: 'Prateek',
    'age': 24,
    'address': {
        houseNo: '123',
        city: 'Ballia',
        state: 'UP',
        country: 'India'
    },
    profiles: ['Github', 'linkedin', 'reddit'],
    printProfiles: () => {
        person.profiles.map(profile => console.log(profile))
    }
}

export default function LearningJs() {
    return (
        <>
            <div className="other-component">{person.name}</div>
            <div>{person.age}</div>
            <div>
                <div>{person.address.city},{person.address.state}</div>
            </div>
            <div>{person.printProfiles()}</div>
        </>
    );
}