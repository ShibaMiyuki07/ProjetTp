import { IonButton, IonContent, IonHeader, IonInput, IonItem, IonLabel, IonList, IonPage, IonTitle, IonToolbar } from "@ionic/react";
import { useState } from "react";

const login = (nom : string,pwd : string) =>{
    console.log(nom);
    console.log(pwd);
}
const Login : React.FC = () =>{
    const [nom,setNom] = useState("");
    const [pwd,setPwd] = useState("");
    return(
        <IonPage>
            <IonHeader>
                <IonToolbar>
                <IonTitle>Login</IonTitle>
                </IonToolbar>
            </IonHeader>
            <IonContent fullscreen>
                <IonHeader collapse="condense">
                <IonToolbar>
                    <IonTitle size="large">Login</IonTitle>
                      
                </IonToolbar>
                </IonHeader>
                <IonList>
                        <IonItem>
                            <IonLabel position="floating">Entrer votre pseudo....</IonLabel>
                            <IonInput name="nom" onIonInput={(e : any) => setNom(e.target.value)}></IonInput>
                        </IonItem>
                        <IonItem>
                            <IonLabel position="floating">Entrer votre pseudo....</IonLabel>
                            <IonInput type="password" name="pwd" onIonInput={(e : any) => setPwd(e.target.value)}></IonInput>
                        </IonItem>
                        <IonItem><IonButton onClick={() => login(nom,pwd)}>Connexion</IonButton></IonItem>
                    </IonList> 
            </IonContent>
        </IonPage>
    );
}

export default Login;