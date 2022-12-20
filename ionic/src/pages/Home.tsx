import { IonButton, IonButtons, IonContent, IonHeader, IonItem, IonLabel, IonList, IonMenu, IonMenuButton, IonMenuToggle, IonModal, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import { useEffect, useState } from 'react';
import axios from "axios";
import ExploreContainer from '../components/ExploreContainer';
import './Home.css';

const Login = () =>{
  document.location.href = "/login";
}

const Details = () =>{
  document.location.href = "/details";
}

const Home: React.FC = () => {
  const [data,setData] = useState([]);
  const [erreur,setErreur] = useState("");
  const [isOpen,setIsOpen] = useState(false);
  /*useEffect(() =>
  {
    axios.get("autre/test").then(data =>{
      console.log(data.data);
      console.log(data.request['status']);
      if(data.request['status'] !== 200)
      {
        setIsOpen(true);
        setErreur("Veuillez vous connecter");
      }
      else
      {
        setData(data.data);
      }
    }).catch((err) =>
    {
      setIsOpen(true);
      setErreur("Veuillez vous connecter");
    })
  })*/
  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Acceuil</IonTitle>
          <IonButton style={{width : 100}} onClick={() => Login()} slot="end">Connexion</IonButton>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">Acceuil</IonTitle>                      
          </IonToolbar>
        </IonHeader>
        <IonModal isOpen={isOpen}>
          <IonLabel>{erreur}</IonLabel>
          <IonButton>OK</IonButton>
        </IonModal>
        <IonList>
        {
          data.map(item =>{
            return (
              <IonItem>
                <IonButton slot='end'>Details</IonButton>
              </IonItem>
            );
          })
        }
        <IonButton onClick={() => Details()}>Details</IonButton>
        </IonList>
      </IonContent>
    </IonPage>
  );
};

export default Home;
